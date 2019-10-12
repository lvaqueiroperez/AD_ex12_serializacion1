package ex12_serializacion1;

import java.io.*;

public class Ex12_serializacion1 {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        MClase obj1 = new MClase("ola", -7, 2.7E10);

        FileOutputStream escribir1 = new FileOutputStream("C:\\Users\\luis-\\Desktop\\2ºDAM\\AD\\ex12\\serial.txt");
        ObjectOutputStream escribirOOS = new ObjectOutputStream(escribir1);

        //El método "writeObject()" de la Clase ObjectOutputStream nos permite escribir un objeto/instancia
        //en un fichero de texto
        escribirOOS.writeObject(obj1);
        escribirOOS.close();
        escribir1.close();

        MClase obj2 = new MClase();

        FileInputStream leer1 = new FileInputStream("C:\\Users\\luis-\\Desktop\\2ºDAM\\AD\\ex12\\serial.txt");
        ObjectInputStream leerOOS = new ObjectInputStream(leer1);

        //Ahora, con el método "readObject()" de la Clase ObjectInputStream podemos
        //recuperar y leer un objeto escrito en un fichero de texto con "writeObject"
        //y asignárselo fácilmente a un objeto instanciado de la Clase en cuestión:
        obj2 = (MClase) leerOOS.readObject();

        leerOOS.close();
        leer1.close();

        System.out.println(obj2);

    }

}

//Podemos declarar clases fuera de la Clase principal si no lo ponemos "public"
//Las clases con public tienen que ser Clases internas o estar en un fichero
//distinto
class MClase implements Serializable {

    private String nome;
//    private int numero1;
    //si creamos una variable o atributo y lo ponemos como "transient", 
    //no podremos recuperar el valor de esa variable mediante una lectura de serialización:
    private transient int numero1;

    private Double numero2;

    public MClase() {

    }

    public MClase(String nome, int numero1, Double numero2) {

        this.numero1 = numero1;
        this.nome = nome;
        this.numero2 = numero2;

    }

    @Override
    public String toString() {
        return "MClase{" + "nome=" + nome + ", numero1=" + numero1 + ", numero2=" + numero2 + '}';
    }

}
