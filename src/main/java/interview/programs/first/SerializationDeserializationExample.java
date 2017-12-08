package interview.programs.first;

import java.io.*;

public class SerializationDeserializationExample {

    public static void main(String[] args) {

        //create an object
        Dog e = new Dog();
        e.setName("bulldog");
        e.setColor("white");
        e.setWeight(5);

        //serialize
        try (FileOutputStream fileOut = new FileOutputStream("./dog.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(e);

            System.out.printf("Serialized dog is saved in ./dog.ser");

        } catch (IOException error) {
            error.printStackTrace(System.err);
        }
        e = null;

        //Deserialize
        try (FileInputStream fileIn = new FileInputStream("./dog.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            e = (Dog) in.readObject();

        } catch (IOException | ClassNotFoundException error) {
            error.printStackTrace(System.err);
            return;
        }

        System.out.println("\nDeserialized Dog ...");
        System.out.println("Name: " + e.getName());
        System.out.println("Color: " + e.getColor());
        System.out.println("Weight: " + e.getWeight());

        e.introduce();

    }

    static class Dog implements Serializable {

        private static final long serialVersionUID = -5742822984616863149L;
        private String name;
        private String color;
        private transient int weight;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public void introduce() {
            System.out.println("I have a " + color + " " + name + ".");
        }
    }
}


