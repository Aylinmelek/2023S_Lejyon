package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import com.mongodb.client.gridfs.model.GridFSDownloadOptions;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;

import domain.controller.ConKUerorHandler;

public class SaveLoadDatabaseService {

	String username;
	String file_path;
	String fileName = "output_map.txt";
	@SuppressWarnings("resource")
	public void saveGameDB(ConKUerorHandler controller) {
		File file = new File(file_path);
		file_path = "src/saves/" + username + ".txt";
		// Save Data Creation
		/*
		username = controller.getPlayer().getUsername();
		file_path = "src/saves/" + username + ".txt";
		File file = new File(file_path);
		try {
			FileOutputStream file_output = new FileOutputStream(file);
			ObjectOutputStream object_output = new ObjectOutputStream(file_output);
			object_output.writeObject(controller);
			object_output.close();
			file_output.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		}*/
		
		 try {
	            FileOutputStream fos = new FileOutputStream(fileName);
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(controller);
	            oos.close();
	            fos.close();
	            System.out.println("Game has been saved to " + fileName);
	        } catch (IOException e) {
	            System.out.println("Error occurred while saving the game to " + fileName);
	            e.printStackTrace();
	        }

		// Database Initializations

//		ConnectionString connectionString = new ConnectionString(
//				"mongodb+srv://admin:<password>@lovelacecollective.7lkz5hz.mongodb.net/?retryWrites=true&w=majority");
//		MongoClientSettings settings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
//		MongoClient mongoClient = MongoClients.create(settings);
//		MongoDatabase db = mongoClient.getDatabase("LovelaceCollective");

		// Creating Credentials
		// Temporary local server.
		MongoClient mongoClient = new MongoClient();
		@SuppressWarnings("unused")
		MongoCredential credential;
		credential = MongoCredential.createCredential("sampleUser", "db", "password".toCharArray());
		// System.out.println("Credentials ::" + credential);

		MongoDatabase db = mongoClient.getDatabase("lejyon2023");
		GridFSBucket gridFSBucket = GridFSBuckets.create(db, "ConKUerorGame");

		try {
			// Upload
			FileInputStream fi = new FileInputStream(file_path);
			ObjectInputStream oi = new ObjectInputStream(fi);
			GridFSUploadOptions options = new GridFSUploadOptions().chunkSizeBytes(1048576) // 1 MB
					.metadata(new Document("username", username));
			InputStream streamToUploadFrom = new FileInputStream(file);
			ObjectId fileId = gridFSBucket.uploadFromStream("Save: " + username, streamToUploadFrom, options);
			System.out.println("The file id of the uploaded file is: " + fileId.toHexString());
			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		}
	}

	public ConKUerorHandler loadGameDB(String username) {

		ConKUerorHandler loaded_controller = ConKUerorHandler.getInstance(); // Temporary controller.
		file_path = "src/saves/" + username + ".txt";
		// Database Initialization
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient();
		@SuppressWarnings("unused")
		MongoCredential credential;
		credential = MongoCredential.createCredential("sampleUser", "db", "password".toCharArray());
		// System.out.println("Credentials ::" + credential);

		MongoDatabase db = mongoClient.getDatabase("lejyon2023");
		GridFSBucket gridFSBucket = GridFSBuckets.create(db, "ConKUerorGame");
		File file_out = new File(file_path);
		try {
			// Download
			GridFSDownloadOptions downloadOptions = new GridFSDownloadOptions();
			FileOutputStream streamToDownloadTo = new FileOutputStream(file_out);
			gridFSBucket.downloadToStream("Save: " + username, streamToDownloadTo, downloadOptions);
			streamToDownloadTo.flush();

			FileInputStream fi_1 = new FileInputStream(file_out);
			ObjectInputStream oi_1 = new ObjectInputStream(fi_1);

			loaded_controller = (ConKUerorHandler) oi_1.readObject();

			oi_1.close();
			fi_1.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loaded_controller;
	}
}
