;测试段安全性

assume cs:code

code segment
    
    mov ax, 0
    mov ds, ax

    mov ds:[26h], ax   ;将会触发错误

    mov ax, 4c00h
    int 21h

code ends

end