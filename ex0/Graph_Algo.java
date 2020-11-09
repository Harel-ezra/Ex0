package ex0;

import java.util.*;

public class Graph_Algo implements graph_algorithms
{
    private graph grAl;

    /**
     * constructor
     */
    public Graph_Algo()
    {
        this.grAl=new Graph_DS(); //new Graph_DS();
    }
    public Graph_Algo(graph g)
    {
        this.grAl=g;
    }
    /**
     * copy
     *
    /**

     * init the pointer graph to this one that got
     * @param g
     */
    @Override
    public void init(graph g)
    {
        this.grAl=g;
    }

    /**
     * made deep copy ot the graph
     * @return
     */
    @Override
    public graph copy()
    {
        graph grNew=new Graph_DS(this.grAl);
        return grNew;
    }

    /**
     * return true of false if the all node are connected together
     * at anything way - that its meaning "connected grape"
     * @return
     */
    @Override
    public boolean isConnected()
    {
        if(grAl.nodeSize()<=1)
        {
            return true;
        }
        node_data n=grAl.getV().iterator().next();
        int j=BFS(n);
        cleanNodeDetails();
        return (j==grAl.nodeSize());
    }

    /**
     * return the length of the shortest way between 2 nodes, src and dest
     * @param src - start node
     * @param dest - end (target) node
     * @return
     */
    @Override
    public int shortestPathDist(int src, int dest)
    {
        if(!grAl.getV().contains(grAl.getNode(src))||!grAl.getV().contains(grAl.getNode(dest)))
        {
            return -1;
        }
        BFS(grAl.getNode(src));
        int l=grAl.getNode(dest).getTag();
        cleanNodeDetails();
        return l;
    }

    /**
     * return the description of the shortest way between 2 nodes, src and dest
     * @param src - start node
     * @param dest - end (target) node
     * @return
     */
    @Override
    public List<node_data> shortestPath(int src, int dest)
    {
        List<node_data> list=new ArrayList<node_data>();
        if(!grAl.getV().contains(grAl.getNode(src))||!grAl.getV().contains(grAl.getNode(dest)))
        { //if no have a path return empty list
            return list;
        }
        BFS(grAl.getNode(src));
        node_data n=grAl.getNode(dest);
        if(n.getTag()==-1)
        {
            cleanNodeDetails();
            return list;
        }
        list.add(0,n);
        int art=0;
        while((n.getTag()!=0)&&(art++<=grAl.nodeSize()))
        {
            for(node_data ni:n.getNi())
            {
                if(ni.getTag()==(n.getTag()-1))
                {
                    list.add(0,ni);
                    n=ni;
                    break;
                }
            }
        }
        cleanNodeDetails();
        return list;
    }

    /**
     * BFS algorithm
     */
    private int BFS(node_data src)
    {
        int counter=0;
        Queue<node_data> que=new LinkedList<node_data>();
        que.add(src);
        src.setInfo("true");
        counter++;
        src.setTag(0);
        while(!que.isEmpty())
        {
            node_data i=que.poll();
           // counter++;
            Collection<node_data> ni= i.getNi();
            for(node_data n:ni)
            {
                if(n.getInfo().equals("false"))
                {
                    n.setInfo("true");
                    que.add(n);
                    counter++;
                    n.setTag(i.getTag()+1);
                }
            }
        }
        return counter;
    }

    /**
     * clear the node at the graph back.
     */
    private void cleanNodeDetails()
    {
        for (node_data n:grAl.getV())
        {
            n.setInfo("false");
            n.setTag(-1);
        }
    }

}
