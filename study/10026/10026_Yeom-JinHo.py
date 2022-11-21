from collections import deque
import sys
def bfs(r,c,color):
  que=deque([[r,c]]);
  while que:
    now=que.popleft();
    r=now[0];
    c=now[1]
    visited[r][c]=True;
    for i in range(4):
      tr=r+dr[i];
      tc=c+dc[i];
      if tr>=0 and tc>=0 and tr<n and tc<n:
        if not visited[tr][tc] and arr[tr][tc]==color:
          que.append([tr,tc]);
          visited[tr][tc]=True;

dr=[0,0,1,-1];
dc=[1,-1,0,0];
n=int(sys.stdin.readline());

arr=list();

for _ in range(n):
  arr.append(list(sys.stdin.readline().rstrip()));
visited=[[False]*n for _ in range(n)];
count1=0;
for r in range(n):
  for c in range(n):
    if not visited[r][c]:
      bfs(r,c,arr[r][c]);
      count1+=1;

for r in range(n):
    for c in range(n):
        if arr[r][c]=='R':
            arr[r][c]='G';

visited = [[False]*n for _ in range(n)]
count2=0
for r in range(n):
    for c in range(n):
        if not visited[r][c]:
            bfs(r,c,arr[r][c])
            print
            count2+=1;

print(count1,count2)