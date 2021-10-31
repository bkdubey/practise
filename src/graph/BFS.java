package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Person
{
    private ArrayList<Integer> friends =
            new ArrayList<Integer>();
    private int personID;
    private String info;

    public Person(int id)
    {
        this.personID =id;
    }
    public String getinfo()
    {
        return info;
    }
    public void setinfo(String info)
    {
        this.info = info;
    }
    public ArrayList<Integer> getFriends()
    {
        return friends;
    }
    public int getID()
    {
        return personID;
    }
    public void addFriend(int id)
    {
        friends.add(id);
    }
}
class PathNode
{
    private Person person = null;
    private PathNode previousNode = null;
    public PathNode(Person p, PathNode previous)
    {
        person = p;
        previousNode = previous;
    }

    public Person getPerson()
    {
        return person;
    }

    public LinkedList<Person> collapse(boolean startsWithRoot)
    {
        LinkedList<Person> path= new LinkedList<Person>();
        PathNode node = this;
        while (node != null)
        {
            if (startsWithRoot)
                path.addLast(node.person);
            else
                path.addFirst(node.person);
            node = node.previousNode;
        }

        return path;
    }
}

class BFSData
{
    public Queue<PathNode> toVisit = new LinkedList<PathNode>();
    public HashMap<Integer, PathNode> visited =
            new HashMap<Integer, PathNode>();

    public BFSData(Person root)
    {
        PathNode sourcePath = new PathNode(root, null);
        toVisit.add(sourcePath);
        visited.put(root.getID(), sourcePath);
    }
    public boolean isFinished()
    {
        return toVisit.isEmpty();
    }
}

class BFS {
    public static void main(String[] args) {
        new BFSData(new Person(1)) ;
    }

    LinkedList<Person> findPathBiBFS(HashMap<Integer, Person> people,
                                     int source, int destination)
    {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));

        while (!sourceData.isFinished() && !destData.isFinished())
        {

            /* Search out from source. */
            Person collision = searchLevel(people, sourceData, destData);
            if (collision != null)
                return mergePaths(sourceData, destData, collision.getID());

            /* Search out from destination. */
            collision = searchLevel(people, destData, sourceData);
            if (collision != null)
                return mergePaths(sourceData, destData, collision.getID());
        }

        return null;
    }


    /* Search one level and return collision, if any.*/
    Person searchLevel(HashMap<Integer, Person> people,
                       BFSData primary, BFSData secondary)
    {

    /* We only want to search one level at a time. Count
       how many nodes are currently
       in the primary's level and only do that many nodes.
       We continue to add nodes to the end. */

        int count = primary.toVisit.size();
        for (int i= 0; i < count; i++)
        {
            /* Pull out first node. */
            PathNode pathNode = primary.toVisit.poll();
            int personId = pathNode.getPerson().getID();

            /* Check if it's already been visited. */
            if (secondary.visited.containsKey(personId))
                return pathNode.getPerson();

            /* Add friends to queue. */
            Person person = pathNode. getPerson();
            ArrayList<Integer> friends = person.getFriends();
            for (int friendId : friends)
            {
                if (!primary.visited.containsKey(friendId))
                {
                    Person friend= people.get(friendId);
                    PathNode next = new PathNode(friend, pathNode);
                    primary.visited.put(friendId, next);
                    primary.toVisit.add(next);
                }
            }
        }
        return null;
    }


    /* Merge paths where searches met at the connection. */
    LinkedList<Person> mergePaths(BFSData bfsl, BFSData bfs2,
                                  int connection)
    {
        // endl -> source, end2 -> dest
        PathNode endl = bfsl.visited.get(connection);
        PathNode end2 = bfs2.visited.get(connection);

        LinkedList<Person> pathOne = endl.collapse(false);
        LinkedList<Person> pathTwo = end2.collapse(true);

        pathTwo.removeFirst(); // remove connection
        pathOne.addAll(pathTwo); // add second path

        return pathOne;
    }
}