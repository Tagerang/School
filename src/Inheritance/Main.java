package Inheritance;

public class Main {

     /* Домашнее задание:
            Нужно реализовать следующую структуру классов на тему «Виды записей в соц. сетях».
            Классы:
            Абстрактная запись – абстрактный класс:
                - поля: автор, дата, сообщение, тип сообщения (запись, репост, комментарий);
                - методы: отобразить контент – вывод на консоль значения полей;
                - абстрактный метод, кот. просто возвращает макс. размер записи (мб).
            Наследники от «Абстрактной записи»:
                - Текстовая запись;
                - Медиа.
            Наследники от «Медиа»:
                - Изображение;
                - Аудио;
                - Видео.
            В каждом наследнике добавьте хотя бы по 1 собственному полю и методу. */

    public static void main(String[] args)
    {
        // Trying to work with the TextNote class
        TextNote textNote = new TextNote("Pavel", "21.02.2021", "Hello World!", "Message");
        textNote.printNote();
        textNote.addComment("Hello to you too!");
        textNote.printNote();

        // Trying to work with the Image class
        Image image = new Image("Ivan", "22.02.2021", "This is my hometown", "Repost", "JPEG", "Petrozavodsk");
        image.printNote();
        image.editGeolocation("Saint-Petersburg");
        image.printNote();
    }

    abstract private static class Note {

        private static String author;
        private static String date;
        private static String message;
        private static String type;

        public Note(String author, String date, String message, String type) {
            Note.author = author;
            Note.date = date;
            Note.message = message;
            Note.type = type;
        }

        void printNote() {
            System.out.printf("Author: %s%n", author);
            System.out.printf("Date: %s%n", date);
            System.out.printf("Message: %s%n", message);
            System.out.printf("Type: %s%n", type);
        }

        abstract int returnMaxSize();
    }

    private static class TextNote extends Note {
        private static String comment;

        public TextNote(String author, String date, String message, String type) {
            super(author, date, message, type);
            comment = "-";
        }

        void addComment(String newComment) {
            comment = newComment;
        }

        @Override
        void printNote() {
            super.printNote();
            System.out.printf("Comment: %s%n", comment);
        }

        int returnMaxSize() {
            return 20;
        }
    }

    private static class MediaNote extends Note {
        private static String extension;

        public MediaNote(String author, String date, String message, String type, String extension) {
            super(author, date, message, type);
            MediaNote.extension = extension;
        }

        void showExtension() {
            System.out.printf("Extension: %s%n", extension);
        }

        @Override
        void printNote() {
            super.printNote();
            showExtension();
        }

        int returnMaxSize() {
            return 1024;
        }
    }

    private static class Image extends MediaNote{
        private static String geolocation;

        public Image(String author, String date, String message, String type, String extension, String geolocation) {
            super(author, date, message, type, extension);
            Image.geolocation = geolocation;
        }

        @Override
        void printNote() {
            super.printNote();
            System.out.printf("Geolocation: %s%n", geolocation);
        }

        void editGeolocation(String newGeolocation){
            geolocation = newGeolocation;
        }
    }

    private static class Audio extends MediaNote {
        private static String name;

        public Audio(String author, String date, String message, String type, String extension, String name) {
            super(author, date, message, type, extension);
            Audio.name= name;
        }

        @Override
        void printNote() {
            super.printNote();
            System.out.printf("Name: %s%n", name);
        }

        void editName(String newName){
            name = newName;
        }
    }

    private static class Video extends MediaNote{
        public static int quality;

        public Video(String author, String date, String message, String type, String extension, int quality) {
            super(author, date, message, type, extension);
            Video.quality = quality;
        }

        @Override
        void printNote() {
            super.printNote();
            showQuality();
        }

        void showQuality() {
            System.out.printf("Quality: %d%n", quality);
        }
    }

}
