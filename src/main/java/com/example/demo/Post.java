package com.example.demo;

import com.mongodb.client.gridfs.GridFSBucket;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
/*GridFS is an API used to store data > 16MB (max size for BSON doc)
 */
@Document(collection = "posts")
public class Post {
        @Id
        private String id;
        private String text;
        private GridFSBucket images;
        private ArrayList<String> comments;

        public Post() {
        }

        public Post(String text, GridFSBucket images, ArrayList<String> comments) {
                this.text = text;
                this.images = images;
                this.comments = comments;
        }

        public String getId() {
                return id;
        }

        public String getText() {
                return text;
        }

        public GridFSBucket getImages() {
                return images;
        }

        public ArrayList<String> getComments() {
                return comments;
        }

        public void setId(String id) {
                this.id = id;
        }

        public void setText(String text) {
                this.text = text;
        }

        public void setImages(GridFSBucket images) {
                this.images = images;
        }

        public void setComments(ArrayList<String> comments) {
                this.comments = comments;
        }
}
