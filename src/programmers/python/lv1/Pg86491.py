# 최소직사각형

def solution(sizes):
    for i in range(len(sizes)):
        if sizes[i][0] < sizes[i][1]:
            tmp = sizes[i][1]
            sizes[i][1] = sizes[i][0];
            sizes[i][0] = tmp
    max_w = max([i[0] for i in sizes])
    max_h = max([i[1] for i in sizes])
    print(max_w, max_h)

    return max_w * max_h