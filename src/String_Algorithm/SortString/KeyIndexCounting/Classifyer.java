package String_Algorithm.SortString.KeyIndexCounting;


/*
*                                     i    0       1       2       3       4       5       6
*                               group[i]jack-3  hohn-2   mike-2  ghgh-1  bobo-3  geroge-0  gfgg-2
*
* new Person("jack",3),               i   0  1  2  3  4
  new Person("hohn",2),         count[i]  1  1  3  2  0
  new Person("mike",2),           \|/
  new Person("ghgh",1),         count[i]  0  1  2  5  7
  new Person("bobo",3),
  new Person("geroge",0)
  new Person("gfgg",2)
                                     i      0       1       2       3       4       5       6
                                  aux[i]                                         jack-3
                                  aux[i]                 hohn-2                  jack-3
                                  aux[i]                 hohn-2   mike-2         jack-3
                                  aux[i]        ghgh-1   hohn-2   mike-2         jack-3
                                  aux[i]        ghgh-1   hohn-2   mike-2         jack-3  bobo-3
                                  aux[i]geroge-0ghgh-1   hohn-2   mike-2         jack-3  bobo-3
                                  aux[i]geroge-0ghgh-1   hohn-2   mike-2 gfgg-2  jack-3  bobo-3




*
*
*
* */
public class Classifyer {
    private int[] count;
    private Person[] group;
    private Person[] aux;
    private int numOfClass;//分为多少类

    Classifyer(Person[] group,int numOfClass){
        this.group = group;
        this.numOfClass = numOfClass;
        count = new int[numOfClass+1];
        aux = new Person[group.length];
    }

    public Person[] classify(){
        //计算每个班出现的频率
        calFreq();
        //将频率转换为起始索引
        transToStartIndex();

        int curClass;
        for (int i = 0;i<group.length;i++){
            curClass = group[i].getGroupId();//这个人所在的班级
            aux[count[curClass]++] = group[i];
        }

        for (int i = 0;i<group.length;i++){
            group[i] = aux[i];
        }
        return group;
    }

    private void calFreq(){
        int id;
        for (int i = 0;i<group.length;i++){
            id = group[i].getGroupId();
            count[id+1] = count[id+1] + 1;
        }
    }

    private void transToStartIndex(){
        for (int i = 0;i<numOfClass;i++){
            count[i+1] = count[i+1] + count[i];
        }
    }
}
