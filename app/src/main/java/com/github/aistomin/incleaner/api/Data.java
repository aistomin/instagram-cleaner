package com.github.aistomin.incleaner.api;

/**
 * Created by aistomin on 06.03.18.
 */
public final class Data {

    private Images images;

    private User user;

    public Images getImages() {
        return images;
    }

    public User getUser() {
        return user;
    }

    public class User {

        private String picture;

        private String name;

        public String getPicture() {
            return picture;
        }

        public String getName() {
            return name;
        }
    }

    public class Images {

        private StandardResolution resolution;

        public StandardResolution getResolution() {
            return resolution;
        }

        public class StandardResolution {

            private String url;

            public String getUrl() {
                return url;
            }
        }
    }
}
