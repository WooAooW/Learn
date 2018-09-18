;实验5任务
;把 a 段 和 b 段的数据求和，存到 c 段

assume cs:code

a segment
    db 1, 2, 3, 4, 5, 6, 7, 8, 9
a ends

b segment
    db 1, 2, 3, 4, 5, 6, 7, 8, 9
b ends

c segment
    db 0, 0, 0, 0, 0, 0, 0, 0, 0
c ends

code segment

    main:
        mov ax, a
        mov ds, ax

        mov bx, 0
        mov cx, 10

        s:
            mov dl, ds:[bx]
            add dl, ds:[bx+16]
            mov ds:[bx+32], dl
            inc bx
            loop s

        mov ax, 4c00h
        int 21h

code ends

end main