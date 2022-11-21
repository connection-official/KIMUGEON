import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main{
  static int N;
  static int[] count;
  static char[][] arr,real;
  static boolean[][] chk;
  final static int[] dr={-1,1,0,0};
  final static int[] dc={0,0,-1,1};
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N=Integer.parseInt(st.nextToken());
    arr =new char[N][N];
    real=new char[N][N];
    for(int r=0;r<N;r++){
      arr[r]=br.readLine().toCharArray();
    }
    deepCopy(real, arr);
    count=new int[2];
    chk=new boolean[N][N];
    for(int r=0;r<N;r++){
      for(int c=0;c<N;c++){
        if(!chk[r][c]){
          dfs(r,c,false);
          count[0]+=1;
        }
      }
    }
    bw.write(count[0]+" ");
    chk=new boolean[N][N];
    deepCopy(arr,real);
    for(int r=0;r<N;r++){
      for(int c=0;c<N;c++){
        if(!chk[r][c]){
          dfs(r,c,true);
          count[1]+=1;
        }
      }
    }
    bw.write(count[1]+"\n");
    bw.flush();
    bw.close();
    br.close();
  }
  static void deepCopy(char[][] a,char[][] b){
    for(int r=0;r<N;r++){
      for(int c=0;c<N;c++){
        a[r][c]=b[r][c];
      }
    }
  }
  static void dfs(int sr,int sc,boolean colorWeak){
    chk[sr][sc]=true;
    int r=sr;
    int c=sc;
    for(int i=0;i<4;i++){
      int tr=r+dr[i];
      int tc=c+dc[i];
      if(tr>=0 && tc>=0 && tr<N && tc<N){
        if(!chk[tr][tc]){
          if(colorWeak){
            if(arr[r][c]=='R' || arr[r][c]=='G'){
              if(arr[tr][tc]=='R'|| arr[tr][tc]=='G'){
                dfs(tr,tc,colorWeak);
              }
            }else{
              if(arr[r][c]==arr[tr][tc]){
                dfs(tr,tc,colorWeak);
              }
            }
          }else{
            if(arr[r][c]==arr[tr][tc]){
              dfs(tr,tc,colorWeak);
            }
          }
        }
      }
    }
  }
}