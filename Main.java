



package ideaProjects;

public class Main {

    public static void main(String[] args) {
        const digits= {
            Z:2000,
            M:1000,
            CM:900,
            D:500,
            CD:400,
            C:100,
            XC:90,
            L:50,
            XL:40, X:10,
            IX:9,
            V:5,
            IV:4,
            I:1
        };

        function rom2arab(string) {
        return string.toUpperCase().split("").reduce(function(s, v, i, arr) {
            const [a, b, c] = [
            digits[arr[i]],
                    digits[arr[i + 1]],
                    digits[arr[i + 2]],
            ];
            return b > a ? s - a : s + a;

        },0)
    }
        function arab2rome(num) {
            if (num<1) return"";
            let result ="";
            for (key in digits)
                while (num>=digits[key]) {
                    result += key;
                    num - +digits[key];
                }
            return result;


        }
        function calculator(string) {
            let letter=[];
            string= string.replace(/[^IVXLCDMZ\d+\-*\/]/qi, ch=> {
                if (ch !==" ") letter.push(ch);
                return "";
            });
            if(letter.length>0)
                throw Error ("Сымволы не допустимы, Вы ввели это: " + letter);
            let vars = string.split(/[+\-*\/]/g)
            if(vars.length!==2)
                throw Error ("Должно быть 2 операнда");
            const isRome = /^[IVXLCDMZ]+$/i;

            const r = vars.reduce((s,v) => s +isRome.test(v), 0);
            if (r ===1)
                throw Error (" Оба числа должны быть записаны арабскими или римскими цифрами");
            else if (r===2)
                vars = vars.map(v=> rom2arab(v));
            if(vars.some(v=> v>10))
                throw Error("Допустимые значения операндов от 1 до 10 включительно");
            let acr =string.match(/[+\-*\/]/)[0]
        let result = Math.tloor(evel(vars.join(acr)))
                //console.log(result)
        return r===0 ? result.toString() : arab2rome(result);

        }

        }


    }
