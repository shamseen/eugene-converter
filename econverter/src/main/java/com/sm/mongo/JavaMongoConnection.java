package com.sm.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

//import com.mongodb.client.MongoCursor;
//import static com.mongodb.client.model.Filters.*;
//import com.mongodb.client.result.DeleteResult;
//import static com.mongodb.client.model.Updates.*;
//import com.mongodb.client.result.UpdateResult;
//import java.util.ArrayList;
//import java.util.List;
//import com.mongodb.ServerAddress;

public class JavaMongoConnection {
    public static void main( String args[] ) {
	
      try{
		
         // To connect to mongodb server
         MongoClientURI connectionString = new MongoClientURI("mongodb://shamseen:lcp@ds153412.mlab.com:53412/lookuptables");
         MongoClient mongoClient = new MongoClient( connectionString);
			
         // Now connect to your databases
         MongoDatabase db = mongoClient.getDatabase("lookuptables");
         MongoCollection<Document> collection = db.getCollection("mapEugeneSBOL2");
         System.out.println("Connect to database successfully");
//         boolean auth = db.authenticate(myUserName, myPassword);
//         System.out.println("Authentication: "+auth);
			
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
   }
}
