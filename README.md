# localization

GET localhost:8080/api/do

Header: Accept-Language=ru

Результат: сообщение один one, 1

-----------------------------------------

GET localhost:8080/api/do

Header: Accept-Language=en, или отсутствует, или не en и не ru 

Результат: message one one, 1

-----------------------------------------

GET localhost:8080/api/do-error

Header: Accept-Language=ru

Результат: какая-то ашыпка: Oooops!

-----------------------------------------

GET localhost:8080/api/do-error

Header: Accept-Language=en, или отсутствует, или не en и не ru

Результат: some error: Oooops!

-----------------------------------------