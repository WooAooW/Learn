;将data段中的每个单词改为大写
;需要用到 2 层循环，最外层的循环计数器 cx 需要保存到临时位置

assume cs:code, ds:data

data segment
    db 'ibm             '
    db 'dec             '
    db 'dos             '
    db 'vax             '
    dw 0                   ;暂存最外层循环的 cx 的值
data ends

code segment

    main:
        mov ax, data
        mov ds, ax

        mov bx, 0
        mov di, 40h        ;保存变量位置的偏移
        mov cx, 4
        s1:
            mov [di], cx  ;保存当前 cx 的值

            mov si, 0
            mov cx, 3
            s2:
                mov al, [bx + si]
                and al, 0DFh
                mov [bx + si], al

                inc si
                loop s2

            mov cx, [di]   ;获取刚才读取到的 cx 的值
            add bx, 10h
            loop s1

        mov ax, 4c00h
        int 21h

code ends

end main