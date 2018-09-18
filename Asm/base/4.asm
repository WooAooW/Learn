;验证 masm 编译器对 [idata] 的处理


assume cs:code

code segment

    mov ax, 2000h
    mov ds, ax

    mov ax, [0]    ;会变成 mov ax, 0000h
    mov bx, [1]
    mov cx, [2]
    mov dx, [3]

    mov ax, 4c00h
    int 21h

code ends

end