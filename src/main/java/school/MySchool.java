package school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

interface StudentCriterion {
  boolean test(Student s);
}

class SmartStudentCriterion implements StudentCriterion {
  @Override
  public boolean test(Student s) {
    return s.getGpa() > 3.0;
  }
}

class EnthusiasticStudentCriterion implements StudentCriterion {
  private int threshold;
  public EnthusiasticStudentCriterion(int threshold) {
    this.threshold = threshold;
  }

  @Override
  public boolean test(Student s) {
    return s.getCourses().size() > threshold;
  }
}

public class MySchool {
  public static List<Student> getSmartStudents(
      Iterable<Student> ls, double threshold) {
    List<Student> out = new ArrayList<>();
//    for(Student s : ls) {
    Iterator<Student> is = ls.iterator();
     while (is.hasNext()) {
       Student s = is.next();
      if (s.getGpa() > threshold) {
        out.add(s);
      }
    }
    return out;
  }

  public static List<Student> getEnthusiasticStudents(
      Iterable<Student> ls, int threshold) {
    List<Student> out = new ArrayList<>();
    for(Student s : ls) {
      if (s.getCourses().size() > threshold) {
        out.add(s);
      }
    }
    return out;
  }

  public static List<Student> getStudentsByCriterion(
      Iterable<Student> ls, StudentCriterion crit) {
    List<Student> out = new ArrayList<>();
    for(Student s : ls) {
      if (crit.test(s)) {
        out.add(s);
      }
    }
    return out;
  }

  public static void showAll(List<Student> ls) {
    for (Student s : ls) {
      System.out.println("> " + s);
    }
    System.out.println("-----------------------");
  }

  public static void main(String[] args) {
    List<Student> roster = Arrays.asList(
        Student.of("Fred", 3.2, "Math", "Physics", "Chemistry"),
        Student.of("Jim", 2.7, "Art", "Philosophy"),
        Student.of("Sheila", 3.9, "Math", "Physics", "Astronomy", "Quantum Mechanics")
    );

    showAll(roster);
    System.out.println("Real smart:");
    showAll(getSmartStudents(roster, 3.0));
    System.out.println("Marketing Smart");
    showAll(getSmartStudents(roster, 2.5));
    System.out.println("Enthusiastic Students");
    showAll(getEnthusiasticStudents(roster, 3));

    System.out.println("Smart by criterion:");
    showAll(getStudentsByCriterion(roster, new SmartStudentCriterion()));
    System.out.println("Enthusiastic by criterion:");
    showAll(getStudentsByCriterion(roster, new EnthusiasticStudentCriterion(2)));
    System.out.println("Seriously enthusiastic by criterion:");
    showAll(getStudentsByCriterion(roster, new EnthusiasticStudentCriterion(3)));

    System.out.println("Not smart students, by anonymous class");
    showAll(getStudentsByCriterion(roster, new
    /*class SmartStudentCriterion implements*/ StudentCriterion() {
      @Override
      public boolean test(Student s) {
        return s.getGpa() < 3.0;
      }
    }
        ));

    System.out.println("Not smart students, by lambda");
    showAll(getStudentsByCriterion(roster, /*new StudentCriterion()*/ /*{*/
      /*@Override
      public boolean test*/(Student s) -> {
        return s.getGpa() < 3.0;
      }
    /*}*/
        ));

    System.out.println("Not smart students, by lambda");
    showAll(getStudentsByCriterion(roster,
        (Student s) -> { return s.getGpa() < 3.0;} ));

  }
}
