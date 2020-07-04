package com.aim.movie;

import java.util.Iterator;

import com.aim.movie.model.Actor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class MovieAppMongo {

    public static void main(String[] args) {

        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        MongoDatabase database = mongoClient.getDatabase("movie");

        MongoCollection<Document> collection = database.getCollection("actors");

        FindIterable<Document> iterDoc = collection.find();
        Iterator<Document> it = iterDoc.iterator();

        Actor actor = new Actor();
        while (it.hasNext()) {
            Document doc = it.next();
            actor.setFirstName(doc.getString("firstName"));
            actor.setLastName(doc.getString("lastName"));
            System.out.println(doc);
            System.out.println("Actor: " + actor);
        }

    }

}