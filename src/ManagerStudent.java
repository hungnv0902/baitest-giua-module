public class ManagerStudent {
    public Student[] students = new Student[100];
    public int count = 0;

    public int addStudent(Student student) {
        for(int i = 0; i < count; i ++) {
            if(count!= 0) {
                if(students[i].getName().equals(student.getName())){
                    return -1;
                }
            }
        }

        if(count > students.length) {
            return 0;
        }

        students[count] = student;
        count ++;
        return 1;
    }

    public boolean editStudent(Student student) {
        int index = -1;
        for(int i = 0; i < count; i ++) {
            if(students[i].getId()==student.getId()) {
                index = i;
            }
        }

        if(index != -1) {
            students[index].setName(student.getName());
            students[index].setAge(student.getAge());
            students[index].setAddress(student.getAddress());
            students[index].setGpa(student.getGpa());
            return true;
        } else {
            return false;
        }
    }

    public boolean remoStudent(int id) {
        int index = -1;
        for(int i = 0; i < count; i ++) {
            if(students[i].getId() == id){
                index = i;
            }
        }

        if(index != -1) {
            for (int i = index; i < count; i ++) {
                students[i] = students[i +1];
            }
            students[count -1] = null;
            count --;
            return true;
        }
        return false;
    }

    public void sortStudent() {
        for(int i = 0; i < count; i ++) {
            for (int j = i + 1;j < count; j ++) {
                if(students[i].getGpa() > students[j].getGpa()) {
                    Student tg = new Student();
                    tg = students[i];
                    students[i] = students[j];
                    students[j] = tg;
                }
            }

        }
    }

    public int returnCount() {
        return count;
    }
}
