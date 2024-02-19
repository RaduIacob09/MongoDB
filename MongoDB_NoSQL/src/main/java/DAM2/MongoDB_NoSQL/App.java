package DAM2.MongoDB_NoSQL;

import org.bson.*;

import com.mongodb.*;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class App 
{
    public static void main( String[] args )
    {
        String connectionString= "mongodb+srv://radu13iacob:1234@mongodb.zmc41vt.mongodb.net/?retryWrites=true&w=majority";
        try (MongoClient mongoClient = MongoClients.create(new ConnectionString(connectionString))){
        	MongoDatabase database = mongoClient.getDatabase("MongoDB");
        	MongoCollection<org.bson.Document> collection = database.getCollection("mi_coleccion");
        	Document document = new Document("nombre", "Ejemplo")
        							.append("edad", 30)
        							.append("ciudad", "EjemploCity");
        	collection.insertOne(document);
        	MongoCursor<Document> cursor = collection.find().iterator();
        	try {
        		while(cursor.hasNext()) {
        			System.out.println(cursor.next().toJson());
        		}
        	} finally {
        		cursor.close();
        	}
        }
    }
}
