import com.sun.istack.internal.Nullable;

// Java 코드
public class Safecall {
    public static void main(String[] args) {
//     호출 미구현

    }
    public String getSelectedDealerName(@Nullable Car car) {
//      값을 가져 올때마다 if() null 체크를 항상 해주어야 한다.
//      car가 값이 null이면 null 반환
        if (car == null) {
            return null;
        }

//      옥션 정보를 가져온다.
        Auction auction = car.getAuction();

        if (auction == null) {
            return null;
        }

        Bid selectedBid = auction.getSelectedBid();

        if (selectedBid == null) {
            return null;
        }


        Dealer dealer = selectedBid.getDealer();

        if (dealer == null) {
            return null;
        }

        return dealer.getName();

    }

    // 임시 허구 클래스
    private class Auction {
        Bid selectedBid;
        public Bid getSelectedBid(){
            return selectedBid;
        }
    }

    private class Bid {
        Dealer dealer ;
        public Dealer getDealer() {

            return dealer;
        }
    }

    private class Dealer {
        private String Name = "딜러";

        public String getName() {
            return Name;
        }
    }

    private class Car {
        public String name = "소나타";

        Auction auction;

        public Auction getAuction() {
            return auction;
        }
    }
}
