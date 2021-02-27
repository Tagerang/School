package Machines;

public class Exceptions {

    static class FullnessException extends Exception
    {
        public FullnessException(String message)
        {
            super(message);
        }
    }

    static class WorkException extends Exception
    {
        public WorkException(String message)
        {
            super(message);
        }
    }
}
