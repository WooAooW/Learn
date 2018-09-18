;将data段中的每个单词改为大写
;需要用到 2 层循环，最外层的循环计数器 cx 保存到栈中

assume cs:code, ds:data, ss:stack

data segment
    db 'ibm             '
    db 'dec             '
    db 'dos             '
    db 'vax             '
data ends

stack segment
    dw 0, 0, 0, 0, 0, 0, 0, 0
stack ends

code segment

    main:
        mov ax, data
        mov ds, ax

        mov ax, stack
        mov ss, ax
        mov sp, 10h

        mov bx, 0
        mov cx, 4
        s1:
            push cx

            mov si, 0
            mov cx, 3
            s2:
                mov al, [bx + si]
                and al, 0DFh
                mov [bx + si], al

                inc si
                loop s2

            pop cx
            add bx, 10h
            loop s1

        mov ax, 4c00h
        int 21h

code ends

end main