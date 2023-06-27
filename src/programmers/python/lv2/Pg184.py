# 게임 맵 최단거리

from collections import deque

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    dx = [-1,1,0,0]
    dy = [0,0,1,-1]
    visited =[[False]*m for _ in range(n)]
    q = deque()
    q.append((0,0))
    visited[0][0] = True
    while q:
        y, x = q.popleft()
        for i in range(4):
            new_y = y+dy[i]
            new_x = x+dx[i]
            if 0<= new_y <n and 0<= new_x <m and maps[new_y][new_x] == 1:
                visited[new_y][new_x] = True
                q.append((new_y, new_x))
                maps[new_y][new_x] = maps[y][x]+1
    if maps[n-1][m-1] == 1:
        return -1
    else:
        return maps[n-1][m-1]
