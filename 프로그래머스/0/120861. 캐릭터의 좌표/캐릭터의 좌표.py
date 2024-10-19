def solution(keyinput, board):
    # board 는 맵의 크기, 초기좌표는 0,0
    # - 맵 크기를 벗어나게 하는 명령은 무시
    # - 맵은 양수/음수/0 합쳐서 크기가 결정됨 (항상 홀수)
    
    key_dir = {
        'up' : (0,1),
        'down' : (0, -1),
        'left' : (-1, 0),
        'right' : (1, 0)
    }
    
    pos = [0, 0]
    
    x_limit = board[0]//2
    y_limit = board[1]//2
    
    for key in keyinput:
        
        
        new_x = pos[0] + key_dir[key][0]
        new_y = pos[1] + key_dir[key][1]
        
        if -x_limit <= new_x <= x_limit:
            pos[0] = new_x
        if -y_limit <= new_y <= y_limit:
            pos[1] = new_y
    
    return pos
        