package SocialNetworkPosts;

public enum PostType {

    MESSAGE("Message"),
    REPOST("Repost"),
    COMMENT("Comment");

    private final String postType;

    PostType(String noteType) {
        this.postType = noteType;
    }

    String getValue() {
       return postType;
    }
}
