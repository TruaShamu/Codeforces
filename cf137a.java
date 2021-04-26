import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
 
public class cf137a {
    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        String inputString = inputReader.nextLine();
        int count = 0;
        int answerCount = 0;
        EventList eList = new EventList();
        eList.Events.add(new Event(inputString.charAt(0), 1));
        for (int i = 1; i < inputString.length(); i++) {
            if (inputString.charAt(i) == eList.Events.get(count).Type) {
                eList.Events.get(count).length++;
            } else {
                eList.Events.add(new Event(inputString.charAt(i), 1));
                count++;
            }
 
        }
        while (eList.Events.size() > 0) {
            if (eList.Events.get(0).length > 5) {
                eList.Events.get(0).length -= 5;
                answerCount++;
 
            } else {
                eList.Events.remove(0);
                answerCount++;
            }
        }
        System.out.println(answerCount);
 
    }
 
}
class Event {
    public int length;
    public char Type;
 
    public Event(char Type, int length) {
        this.length = length;
        this.Type = Type;
    }
 
 
}
 
class EventList {
 
    // These variables are static because you don't need multiple copies
    // for sorting, as they have no intrinsic state.
    static private Comparator<Event> ascLocation;
 
    // We initialize static variables inside a static block.
    //1. Interface
    static {
        ascLocation = new Comparator<Event>() {
            @Override
            public int compare(Event p1, Event p2) {
                return Integer.compare(p1.length, p2.length);
            }
        };
 
    }
 
    //2.Property
 
    ArrayList<Event> Events = new ArrayList<Event>();
 
    //3. Method
    //a. Set /Get
    //b. General Function(Method>
 
 
    public ArrayList<Event> GetEventss() {
        return this.Events;
    }
 
    EventList() {
 
    }
 
 
 
    /*public Book[] getBooks() {
        return books;
    } */
 
    public void sortbylocation() {
        Collections.sort(Events, ascLocation);
    }
 
 
    public EventList(ArrayList<Event> oEvents) {
        this.Events = oEvents;
    }
}
 
 
 
 
 
/*
    @Test
    public void sortBooks() {
        Event[] Events = {
                new Event(0, 100, "S"),
                new Event(1, 100, "E")
        };
 
        // 1. sort using Comparable
        Arrays.sort(Events);
        System.out.println(Arrays.asList(Events));
 
        // 2. sort using comparator: sort by id
        Arrays.sort(Events, new Comparator<Events>() {
            @Override
            public int compare(Event o1, Event o2) {
                return (o1.Location - o2.Location);
            }
        });
        System.out.println(Arrays.asList(Events));
    }
*/
