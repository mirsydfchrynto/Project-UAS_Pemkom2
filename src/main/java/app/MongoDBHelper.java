package app;

import com.mongodb.client.*;
import org.bson.Document;
import java.util.ArrayList;
import java.util.List;

public class MongoDBHelper {

    private static final String URI = "mongodb://localhost:27017/";
    private static final String DB_NAME = "manajemen_barang";

    public static MongoDatabase getDatabase() {
        MongoClient client = MongoClients.create(URI);
        return client.getDatabase(DB_NAME);
    }

    // ------------------ Barang Section ------------------
    private static MongoCollection<Document> getBarangCollection() {
        return getDatabase().getCollection("barang");
    }

    public static void insertItem(Item item) {
        // Cek apakah sudah ada barang dengan nama yang sama
        Document existing = getBarangCollection().find(new Document("nama", item.getNama())).first();

        // Jika belum ada, baru insert
        if (existing == null) {
            Document doc = new Document("nama", item.getNama())
                    .append("kategori", item.getKategori())
                    .append("tanggalBeli", item.getTanggalBeli())
                    .append("kondisi", item.getKondisi())
                    .append("jumlah", item.getJumlah());
            getBarangCollection().insertOne(doc);
        } else {
            System.out.println("Barang dengan nama '" + item.getNama() + "' sudah ada. Tidak ditambahkan ulang.");
        }
    }

    public static List<Item> loadAll() {
        List<Item> list = new ArrayList<>();
        for (Document doc : getBarangCollection().find()) {
            list.add(new Item(
                    doc.getString("nama"),
                    doc.getString("kategori"),
                    doc.getString("tanggalBeli"),
                    doc.getString("kondisi"),
                    doc.getInteger("jumlah", 0) // default 0 jika tidak ada
            ));
        }
        return list;
    }

    public static void deleteItemByNama(String nama) {
        Document query = new Document("nama", nama);
        getBarangCollection().deleteOne(query);
    }

    // ------------------ User Section ------------------
    public static MongoCollection<Document> getUserCollection() {
        return getDatabase().getCollection("user");
    }

    public static void insertUser(String username, String encryptedPassword) {
        Document doc = new Document("username", username)
                .append("password", encryptedPassword);
        getUserCollection().insertOne(doc);
    }
//
//    public static Document findUser(String username) {
//        return getUserCollection().find(new Document("username", username)).first();
//    }

    // ------------------ Tambahan: Hapus Semua Barang ------------------
    public static void deleteAll() {
        getBarangCollection().deleteMany(new Document());
    }

    public static void updateItemByNama(String namaLama, Item itemBaru) {
        Document query = new Document("nama", namaLama);

        Document update = new Document("$set", new Document("nama", itemBaru.getNama())
                .append("kategori", itemBaru.getKategori())
                .append("tanggalBeli", itemBaru.getTanggalBeli())
                .append("kondisi", itemBaru.getKondisi())
                .append("jumlah", itemBaru.getJumlah())
        );
        
        getBarangCollection().updateOne(query, update);
    }

    public static Document findUserByUsername(String username) {
        return getUserCollection().find(new Document("username", username)).first();
    }
}
