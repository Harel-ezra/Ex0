

NodeData class:

In this class I used a static counter to give ID to each node
I saved the neighbors of each node in a new Hashmap to have direct access to each neighbor by its ID
I initialized the tag and info variables to minus 1 and "not visited" to use them in the algorithm class

Graph_DS class:

I saved all the nodes in a new hashm to have direct access to each node and so also to have direct access
To each neighbor of a node - to know if there is a edge between them
Deleting a node I first remove all the edge from it - I erased all the neighbors from it - and then I remove the node from the graph

Graph_Algo class:

At the Algo calss I saved class has a HashMap variable to save the way out of a particular node
So each key contains the ID of a particular node and its value contains the ID of its "father".
I used the BFS algorithm. I created two functions, one that saves all the way from a particular node
Until the vertices that are connected to it are finished and the second one that checks if it is connected to a certain node and checks what is the shortest way to it