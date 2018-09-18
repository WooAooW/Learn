;将 data 段中每个英文单词的 前4个变成大写

assume cs:code, ds:data, ss:stack

data segment
    db '1. display      '
    db '2. brows        '
    db '3. replace      '
    db '4. modify       '
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
            mov cx, 4
            s2:
                mov al, [bx + si +3]
                and al, 0DFh
                mov [bx + si + 3], al

                inc si
                loop s2

            pop cx
            add bx, 10h
            loop s1

        mov ax, 4c00h
        int 21h

code ends

end main