;pf标志位
;命令执行结果1的个数, 如果为偶数 pf = 1
;debug 工具中 PE 表示 pf = 1, P0 表示 pf = 0

assume cs:code

code segment
    main:
        mov al, 1
        add al, 10b
        add al, 100b

        mov ax, 4c00h
        int 21h
code ends

end main