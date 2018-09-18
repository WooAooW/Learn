;dw 写入字节型数据
;end 标签，指定程序的入口

assume cs:code

code segment

    dw 0123h, 0456h, 0789h, 0abch, 0defh

    main:
        mov ax, 0
        mov bx, 0
        mov cx, 5
        s:
            mov ax, cs:[bx]
            add ax, cs:[bx]
            add bx, 2
            loop s

    mov ax, 4c00h
    int 21h

code ends

end main