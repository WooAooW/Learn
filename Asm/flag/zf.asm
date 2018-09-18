;zf标志位
;如果命令执行结果为 0, zf = 1
;debug 工具中 NZ 表示 zf = 0, ZR 表示 zf = 1

assume cs:code

code segment
    main:
        mov ax, 2
        sub ax, 1
        sub ax, 1 
        sub ax, 1

        mov ax, 4c00h
        int 21h
code ends

end main