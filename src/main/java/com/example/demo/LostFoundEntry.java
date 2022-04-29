package com.example.demo;

import com.mongodb.client.gridfs.GridFSBucket;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "lost&found")
public class LostFoundEntry {
    @Id
    private  String id;
    private GridFSBucket images;
    private String description;
    //location


    public LostFoundEntry() {
    }

    public LostFoundEntry(GridFSBucket images, String description) {
        this.images = images;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public GridFSBucket getImages() {
        return images;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImages(GridFSBucket images) {
        this.images = images;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
