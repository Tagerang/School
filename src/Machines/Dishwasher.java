package Machines;

public class Dishwasher {

    /* Домашнее задание:
            Создать класс Dishwasher, который моделирует работу посудомоечной машины. Вы можете:
            a.  загружать посуду по одному элементу (нельзя, если машина запущена либо чистая посуда не выгружена); загрузить посуду можно, если позволяет вместимость (задается в конструктуре и определяет макс кол-во загруженной посуды);
            b.  достать всю посуду;
            c.  запустить машину (нельзя, если машина пустая либо чистая посуда не выгружена, либо уже запущена);
            d.  остановить работу машины (нельзя, если не запущена);

            Добавьте эксепшены в программу для обработки некорректного пользования машинкой (например, нельзя добавить посуду, если машина уже запущена) - используйте свои классы для эксепшенов.
            В конструктуре входной параметр должен быть больше 0 - используйте стандартный эксепшн, подходящий по назначению.
            К методам должны быть добавлены java docs с описанием метода, входных параметров, результата и возможных эксепшенов. */

    public static void main(String[] args) throws Exceptions.FullnessException, Exceptions.WorkException {
        // Trying to work with Dishwasher
        Dishwasher dishwasher = new Dishwasher(25);
        for (int i = 0; i < 25; i++) {
            dishwasher.putOneDish();
        }
        //  dishwasher.getAllTheDishes();
        //  dishwasher.getAllTheDishes();
        dishwasher.runDishwasher();
        // dishwasher.runDishwasher();
        dishwasher.stopDishwasher();
        // dishwasher.stopDishwasher();
        // dishwasher.runDishwasher();
        dishwasher.getAllTheDishes();
    }

    private static boolean working;
    private static boolean fullness;
    private static boolean cleanDishes;
    private static int maximumCapacity;
    private static int dishesCount;

    public Dishwasher(int maximumCapacity) {
        if (maximumCapacity > 0) {
            Dishwasher.maximumCapacity = maximumCapacity;
            Dishwasher.dishesCount = 0;
            Dishwasher.working = false;
            Dishwasher.fullness = false;
            Dishwasher.cleanDishes = false;
        } else {
            throw new NumberFormatException("The value cannot be less than or equal to zero.");
        }
    }

    /**
     * Puts one dish in the dishwasher.
     * @throws Exceptions.FullnessException - Can be thrown if the dishwasher is full.
     * @throws Exceptions.WorkException - Can be thrown if the dishwasher is already running.
     */
    public void putOneDish() throws Exceptions.FullnessException, Exceptions.WorkException {
        if (!working) {
            if (!fullness) {
                dishesCount++;
                cleanDishes = false;
                if (dishesCount == maximumCapacity) {
                    fullness = true;
                }
            } else {
                throw new Exceptions.FullnessException("Dishwasher is full.");
            }
        } else {
            throw new Exceptions.WorkException("Dishes can't be put. Dishwasher works.");
        }
    }

    /**
     * Empty the dishwasher. It doesn't matter if the dishes are clean or not.
     * @throws Exceptions.FullnessException - Can be thrown if the dishwasher is already empty.
     */
    public void getAllTheDishes() throws Exceptions.FullnessException {
        if (fullness) {
            dishesCount = 0;
            fullness = false;
        } else {
            throw new Exceptions.FullnessException("Dishwasher is empty.");
        }
    }

    /**
     * Starts the dishwasher.
     * @throws Exceptions.WorkException - Can be thrown if the dishwasher is already running.
     * @throws Exceptions.FullnessException - Can be thrown if the dishwasher is already empty or clean dishes are not removed.
     */
    public void runDishwasher() throws Exceptions.WorkException, Exceptions.FullnessException {
        if (dishesCount != 0) {
            if (!working) {
                if (!cleanDishes) {
                    working = true;
                }
                else {
                    throw new Exceptions.FullnessException("The dishwasher can't be started. Clean dishes not removed.");
                }
            } else {
                throw new Exceptions.WorkException("The dishwasher can't be started. Dishwasher is already run.");
            }
        } else {
            throw new Exceptions.FullnessException("The dishwasher can't be started. Dishwasher is empty.");
        }
    }

    /**
     * Stops the dishwasher. Keeps dishes clean.
     * @throws Exceptions.WorkException - Can be thrown if the dishwasher is not run.
     */
    public void stopDishwasher() throws Exceptions.WorkException {
        if (working) {
            cleanDishes = true;
            working = false;
        } else {
            throw new Exceptions.WorkException("The dishwasher can't be stopped. Dishwasher is not run.");
        }
    }

}
