
# - stock management using dictionary
# 지문(플로우차트)의 요구를 충족하는 재고 관리 프로그램 완성하기
# 아래의 26-27행의 condition 및 pass로 처리된 코드 완성하기

Item_list = ("커피", "콜라", "쥬스", "생수", "탄산수")
Price_list = (1000, 1400, 1200, 800, 900)

#stock entry & init values
stock, stock_amount, i, total_sale = {}, 0, 0, 0


for item in Item_list:
    stock[item] = [Price_list[i], 20]   #새 원소 추가
    stock_amount += Price_list[i]*20    #입고 금액 합산
    i += 1

print("입고 목록:")
for k, v in stock.items():
    print(f"{k}: {v}")
print(f"입고 총액 = {stock_amount}")

while True:
    item = input("무엇을 파시겠습니까? ")
    if not item or item.upper() == "END": break
    if item in Item_list:
       a = int(input("몇 개를 파시겠습니까?"))
       if stock[item][1] >= a:
           sale= stock[item][0]*a
           stock[item][1]= stock[item][1] -a
           print("판매금액:", sale)
           total_sale+= sale
       else:
               print("재고가 부족합니다."), print("재고량 :", stock[item][1])
    else:
        print("해당되는 품목이 없습니다."), print("\n재고 목록:")
        
for k, v in stock.items():
    print(f"{k}: {v}")
print("매출 총액:", total_sale)
