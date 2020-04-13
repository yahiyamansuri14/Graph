import java.util.Scanner;
class Graph{
    private String vertex[]={"Mohave","Coconio","Navajo","Apache","Greenlee","Cochise","Santa Cruz","Pima","Pinal","Graham","Gila","Yavapai","La Paz","Yuma","Maricopa"};
    private final int rows;
    private final int cols;
    private int incMat[][];
    //constructor to assign values to rows and columns
    Graph(){
        rows=15;
        cols=15;
        incMat=new int [rows][cols];
    }
	//method to add an edge in the graph
	public void createEdge(int to_vertex,int from_vertex,int edge){
		if(to_vertex>rows || from_vertex>cols){
			throw new ArrayIndexOutOfBoundsException("You can't enter vertex more than"+rows);
		}else
		{	
			incMat[to_vertex][from_vertex]=edge;
			incMat[from_vertex][to_vertex]=edge;
		}
	}
	
	//method to print Adjancy Matrix
	public void printMatrix(){
		for(int i=1;i<rows;i++)
			System.out.print("\t"+i);
		System.out.println();
		for(int i=1;i<rows;i++){
			System.out.print(" "+i);
			for(int j=1;j<rows;j++){
				System.out.print("\t"+getEdge(i,j));
			}
			System.out.println();
		}
		
	}
	/*
	Enable this method to find neighbour vertex using String value of the vertex then send data in String type from main method line no 130
	public void printNeighbourVertex(String vertex){
		int index=getIndex(vertex);
		for(int i=1;i<rows;i++){
			int temp=getEdge(vertex,i);
			if(temp==1)
				System.out.println(i+"is neighbour vertex of"+vertex);
		}
	}*/
	//method to get neighbour vertex
	public void printNeighbourVertex(int vertex){
		for(int i=1;i<rows;i++){
			int temp=getEdge(vertex,i);
			if(temp==1)
				System.out.println(i+"is neighbour vertex of"+vertex);
		}
	}
	//method to get an Edge
	private int getEdge(int v1,int v2){
		
			if(incMat[v1][v2]>0)
				return 1;
			else 
				return 0;
		
	}
	//method to get Index of Vertices
	private int getIndex(String v){
		for(int i=0;i<vertex.length;i++){
			if(vertex[i].equals(v))
				return i;
		}
		return -1;
	}


		/*Enable this method if you want to get Distance through String value of vertex then send data in string format from main method line no 149
		public void getDistance(int vertex1,int vertex2){
			//int vertex1=getIndex(v1); 
			//int vertex2=getIndex(v2);
			if(vertex1<0 || vertex2<0){
				System.out.println("vertex doesn't exist");
				return;
			}
			if(incMat[vertex1][vertex2]>0 || incMat[vertex2][vertex1]>0){
				System.out.println("weight is:-"+incMat[vertex1][vertex2]);
			}else
				System.out.println("Edge doesn't exist");
		 }*/
		 //enable this method if you want to get Distance using integer value of vertex
		public void getDistance(int vertex1,int vertex2){
			
			if(vertex1<0 || vertex2<0){
				System.out.println("vertex doesn't exist");
				return;
			}
			if(incMat[vertex1][vertex2]>0 || incMat[vertex2][vertex1]>0){
				System.out.println("weight is:-"+incMat[vertex1][vertex2]);
			}else
				System.out.println("Edge doesn't exist");
		 }
    public static void main(String args[]){ 
        
		int vertices,edges,to_vertex,from_vertex,count=1,edge_weight;
        Scanner scan=new Scanner(System.in);
        //System.out.println("Enter no of vertices");
        //vertices=scan.nextInt();
        System.out.println("Enter no of edges;should not be greater than 105");//edge no can't be greater than 105 because of n(n+1)/2 formula
        edges=scan.nextInt();
        Graph graph=new Graph();//creating an object of class graph
        while(count<=edges){
            System.out.println("enter from vertex of edge");
            from_vertex=scan.nextInt();
            System.out.println("enter to vertex of edge");
            to_vertex=scan.nextInt();
            //System.out.println("enter edge no");
            //edge_no=scan.nextInt();
            System.out.println("enter weight of edge");
            edge_weight=scan.nextInt();
            graph.createEdge(from_vertex,to_vertex,edge_weight);
            System.out.println("edge inserted successfully");
            count++;
        }
        graph.printMatrix();
		int ch;
		do{
			System.out.println("enter 1 to find neighbour vertex\nenter 2 to find weight of an edge\n");
			int choice=scan.nextInt();
			switch(choice){
				case 1:
					System.out.println("Enter vertex which neighbour you want to know");
					int v=scan.nextInt();
					graph.printNeighbourVertex(v);
					break;
				case 2:
					int str1,str2;
					scan.nextLine();
					System.out.println("Enter vertex 1");
					str1=scan.nextInt();
					System.out.println("Enter vertex 2");
					str2=scan.nextInt();
					graph.getDistance(str1,str2);
			}
			System.out.println("Enter '1' to continue\n Enter '0' to break");
			ch=scan.nextInt();
			if(ch==0)
				break;
		}while(ch==1);
    }
}
