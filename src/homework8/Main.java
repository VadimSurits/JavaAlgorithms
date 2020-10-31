package homework8;

import java.util.Random;

class Item{
    private int data;

    public Item(int data){
        this.data = data;
    }

    public int getKey(){
        return this.data;
    }
}

class HashTable {
    private Item[] hashArr;
    private int arrSize;
    private Item nonItem;

    public HashTable(int size) {
        this.arrSize = size;
        hashArr = new Item[arrSize];
        nonItem = new Item(-1);
    }

    public void display(){
        for (int i = 0; i < arrSize; i++) {
            if(hashArr[i] != null){
                System.out.println(hashArr[i].getKey());
            } else{
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int key){
        return key % arrSize;
    }

    public void insert(Item item){
        int key = item.getKey();
        int hashVal = hashFunc(key);
        while(hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1){
            ++hashVal;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public Item delete(int key){
        int hashVal = hashFunc(key);
        while(hashArr[hashVal] != null){
            if(hashArr[hashVal].getKey() == key){
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item find(int key){
        int hashVal = hashFunc(key);
        while(hashArr[hashVal] != null){
            if(hashArr[hashVal].getKey() == key){
                return hashArr[hashVal];
            }
            ++hashVal;
            hashVal %= arrSize;
        }
        return null;
    }
}

class HashTable2 {
    private Item[] hashArr;
    private int arrSize;
    private Item nonItem;

    public HashTable2(int size) {
        this.arrSize = size;
        hashArr = new Item[arrSize];
        nonItem = new Item(-1);
    }

    public void display(){
        for (int i = 0; i < arrSize; i++) {
            if(hashArr[i] != null){
                System.out.println(hashArr[i].getKey());
            } else{
                System.out.println("***");
            }
        }
    }

    public int hashFunc(int key){
        return key % arrSize;
    }

    public int hashFuncDouble(int key){
        return 5 - key % 5;
    }

    public void insert(Item item){
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while(hashArr[hashVal] != null && hashArr[hashVal].getKey() != -1){
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        hashArr[hashVal] = item;
    }

    public Item delete(int key){
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while(hashArr[hashVal] != null){
            if(hashArr[hashVal].getKey() == key){
                Item temp = hashArr[hashVal];
                hashArr[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        return null;
    }

    public Item find(int key){
        int hashVal = hashFunc(key);
        int stepSize = hashFuncDouble(key);
        while(hashArr[hashVal] != null){
            if(hashArr[hashVal].getKey() == key){
                return hashArr[hashVal];
            }
            hashVal += stepSize;
            hashVal %= arrSize;
        }
        return null;
    }
}


public class Main {
    public static void main(String[] args) {

        // Задание 8.1: Приведите пример использование хеш-таблиц.
        // Ответ: хранение личных данных пользователей, таких как логин и пароль на большинстве популярных интернет
        // сайтов и онлайн сервисов

        // Задание 8.2: Приведите примеры ключей и коллизий.
        // Ключем может быть логин или пароль, например.
        // Вариант колизии при хэшировании - одинаковые значения хэширования для разных ключей.

        // Задание 8.3: Приведите примеры популярных и эффективных хеш-функций.
        // Примером популярной и эффективной хеш-функции является алгоритм хеширования MD5, который используется для
        // проверки целостности файлов или поиска дубликатов.

        // Задание 8.4: Реализуйте хеш-таблицу с помощью открытой адресации, а конкретнее метода линейного пробирования
        System.out.println("Задание 8.4. Реализация хеш-таблицы с помощью метода линейного пробирования. ");
        Item aDataItem;
        int aKey;
        int size = 66;

        HashTable hashTable = new HashTable(size);
        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            aKey = random.nextInt(999);
            aDataItem = new Item(aKey);
            hashTable.insert(aDataItem);
        }

        hashTable.display();

        // Задание 8.5: Перестройте программный код задания 8.4 из алгоритма линейного пробирования в алгоритм двойного
        // хеширования. Сравните отличительные черты двух алгоритмов.
        System.out.println("\nЗадание 8.5. Реализация алгоритма двойного хеширования. ");

        HashTable2 hashTable2 = new HashTable2(size);

        for (int i = 0; i < 15; i++) {
            aKey = random.nextInt(999);
            aDataItem = new Item(aKey);
            hashTable2.insert(aDataItem);
        }

        hashTable2.display();
    }
}
