import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

public class Main {

    public HashMap<Integer, Student> buildMap(Student[] students) {
        HashMap<Integer, Student> map = new HashMap<>();
        for (Student s: students) map.put(s.getId(), s);
        return map;
    }

    public ArrayList<String> merge(String[] words, String[] more){
        ArrayList<String> sentence = new ArrayList<>();
        for (String w: words) sentence.add(w);
        for (String m: more) sentence.add(m);
        return sentence;
    }

    public static void main(String[] args) {
    /*    Student[] students = new Student[2];
        Student student1 = new Student("Sean", 1);
        Student student2 = new Student("Mandy", 2);
        students[0]=student1;
        students[1]=student2;
        Main m= new Main();
        HashMap<Integer, Student> h = m.buildMap(students);
        for(Student s:h.values()){
            System.out.println(" the student name and id are " + s.getId() + s.getName());
        }
        System.out.println("Hello World!");

        String[] string = {"hello","world"};
        String[] string2 = {"hello2","world2"};
        ArrayList<String> mString =m.merge(string, string2);
        for(String words:mString){
            System.out.print(words + ",");
        }*/
        Node n = new Node(1);
        Node root = new Node(0);
        root.appendToTail(3);
        Node currentNode = root;
        while(currentNode!=null){
            System.out.println(currentNode.data);
            currentNode= currentNode.next;
        }

    }
}
