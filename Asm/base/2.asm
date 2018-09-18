;计算 236 * 123 程序
;使用循环标记 loop

assume cs:code

code segment
    
    mov ax, 0
    mov cx, 236

    s: add ax, 123
    loop s

    mov bx, ax

    mov ax, 4c00h
    int 21h
code ends
end