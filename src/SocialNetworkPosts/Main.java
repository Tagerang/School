package SocialNetworkPosts;

public class Main {

     /* Домашнее задание:
            Нужно реализовать следующую структуру классов на тему «Виды записей в соц. сетях».
            Классы:
            Абстрактная запись – абстрактный класс:
                - поля: автор, дата, сообщение, тип сообщения (запись, репост, комментарий) // для типа использовать enum вместо String;
                - методы: отобразить контент – вывод на консоль значения полей;
                - абстрактный метод, кот. просто возвращает макс. размер записи (мб).
            Наследники от «Абстрактной записи»:
                - Текстовая запись;
                - Медиа.
            Наследники от «Медиа»:
                - Изображение;
                - Аудио;
                - Видео.
            В каждом наследнике добавьте хотя бы по 1 собственному полю и методу.

            Интерфейсы:
                - Печатаемая запись с методом «распечатать» - д.б. быть у «Текстовой записи» и «Изображении»;
                - Проигрываемая запись с методом «воспроизвести» - д.б. быть у «Аудио» и «Видео»; */

    public static void main(String[] args)
    {
        // Trying to work with the TextPost class
        TextPost textPost = new TextPost("Pavel", "21.02.2021", "Hello World!", PostType.MESSAGE);
        textPost.printPost();
        textPost.addComment("Ivan","22.02.2021","Hello to you too!");
        textPost.printPost();
        textPost.print();

        // Trying to work with the Image class
        Image image = new Image("Ivan", "22.02.2021", "This is my hometown", PostType.REPOST, "JPEG", "Petrozavodsk");
        image.printPost();
        image.editGeolocation("Saint-Petersburg");
        image.printPost();
        image.print();
    }

    abstract private static class Post {

        private static String author;
        private static String date;
        private static String message;
        private static PostType type;

        public Post(String author, String date, String message, PostType type) {
            Post.author = author;
            Post.date = date;
            Post.message = message;
            Post.type = type;
        }

        void printPost() {
            System.out.printf("Author: %s%n", author);
            System.out.printf("Date: %s%n", date);
            System.out.printf("Message: %s%n", message);
            System.out.printf("Type: %s%n", type.getValue());
        }

        abstract int returnMaxSize();
    }

    private static class TextPost extends Post implements PrintablePost {
        private static TextPost comment;

        public TextPost(String author, String date, String message, PostType type) {
            super(author, date, message, type);
            comment = null;
        }

        void addComment(String author, String date, String comment) {
            TextPost.comment = new TextPost(author, date, comment, PostType.COMMENT);
        }

        @Override
        void printPost() {
            super.printPost();
            System.out.printf("Comment: -%n%n");
        }

        int returnMaxSize() {
            return 20;
        }

        public void print() {
            System.out.printf("Post has been sent to print%n%n");
            // Sending a Post for printing
        }
    }

    private static class MediaPost extends Post {
        private static String extension;

        public MediaPost(String author, String date, String message, PostType type, String extension) {
            super(author, date, message, type);
            MediaPost.extension = extension;
        }

        void showExtension() {
            System.out.printf("Extension: %s%n", extension);
        }

        @Override
        void printPost() {
            super.printPost();
            showExtension();
        }

        int returnMaxSize() {
            return 1024;
        }
    }

    private static class Image extends MediaPost implements PrintablePost{
        private static String geolocation;

        public Image(String author, String date, String message, PostType type, String extension, String geolocation) {
            super(author, date, message, type, extension);
            Image.geolocation = geolocation;
        }

        @Override
        void printPost() {
            super.printPost();
            System.out.printf("Geolocation: %s%n%n", geolocation);
        }

        void editGeolocation(String newGeolocation){
            geolocation = newGeolocation;
        }

        public void print() {
            System.out.printf("Image has been sent to print%n%n");
            // Sending an image for printing
        }
    }

    private static class Audio extends MediaPost implements PlayablePost {
        private static String name;

        public Audio(String author, String date, String message, PostType type, String extension, String name) {
            super(author, date, message, type, extension);
            Audio.name= name;
        }

        @Override
        void printPost() {
            super.printPost();
            System.out.printf("Name: %s%n%n", name);
        }

        void editName(String newName){
            name = newName;
        }

        public void play() {
            System.out.printf("The audio will play in a couple of seconds%n%n");
            // Audio playback
        }
    }

    private static class Video extends MediaPost implements PlayablePost {
        public static int quality;

        public Video(String author, String date, String message, PostType type, String extension, int quality) {
            super(author, date, message, type, extension);
            Video.quality = quality;
        }

        @Override
        void printPost() {
            super.printPost();
            showQuality();
        }

        void showQuality() {
            System.out.printf("Quality: %d%n%n", quality);
        }

        public void play() {
            System.out.printf("The video will play in a couple of seconds%n%n");
            // Video playback
        }
    }

    private interface PrintablePost {
        void print();
    }

    private interface PlayablePost {
        void play();
    }
}
