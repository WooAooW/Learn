;把 mov ax, 4c00h 之前的指令复制到 0:200 处

assume cs:code

code segment

    mov ax, cs
    mov ds, ax

    mov ax, 0020h
    mov es, ax

    mov bx, 0
    mov cx, 17h         ;需要先填入一个值后，查看 mov ax, 4c00h 的位置
    s:
        mov al, [bx]
        mov es:[bx], al
        inc bx
        loop s
    mov ax, 4c00h
    int 21h

code ends

end