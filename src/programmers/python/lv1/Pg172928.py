# 공원 산책

def solution(park, routes):
    loc = [0,0]
    w = len(park[0])
    h = len(park)
    for i in range(len(park)):
        if 'S' in park[i]:
            loc[0] = i
            loc[1] = park[i].index('S')
            break
    for route in routes:
        new_loc = [loc[0], loc[1]]
        for i in range(int(route[2])):
            if route[0] == 'E' and new_loc[1]+1 < w and park[new_loc[0]][new_loc[1]+1] != 'X':
                new_loc[1]+=1
                if i == int(route[2])-1:
                    loc[1] = new_loc[1]
            elif route[0] == 'W' and new_loc[1]-1 >= 0 and park[new_loc[0]][new_loc[1]-1] != 'X':
                new_loc[1]-=1
                if i == int(route[2])-1:
                    loc[1] = new_loc[1]
            elif route[0] == 'S' and new_loc[0]+1 < h and park[new_loc[0]+1][new_loc[1]] != 'X':
                new_loc[0]+=1
                if i == int(route[2])-1:
                    loc[0] = new_loc[0]
            elif route[0] == 'N' and new_loc[0]-1 >= 0 and park[new_loc[0]-1][new_loc[1]] != 'X':
                new_loc[0]-=1
                if i == int(route[2])-1:
                    loc[0] = new_loc[0]
    return loc