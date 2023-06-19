package test.SF_X0603;

public class T2 {
//    public List<HistoryResult> query(int pageNo, int pageSize) {
//    }
//
//    /**
//     * 查询某个用户的处罚记录，记录按照id升序排序
//     *
//     * @param userId 用户
//     * @return 处罚记录
//     */
//    public List<HistoryResult> getByUserId(int userId) {
//    }
//
//    /**
//     * 处罚操作, 如果用户已经有被处罚了，新的处罚不能低于当前处罚等级才能生效
//     *
//     * @param operatorUserName 操作者的名字
//     * @param userId           处罚的用户
//     * @param punishStatus     处罚类型
//     * @return 返回处罚的记录id, 处罚不成功返回-1
//     */
//    public int punish(String operatorUserName, int userId, int punishStatus) {
//    }
//
//    /**
//     * 解除当前处罚
//     *
//     * @param operatorUserName 操作者的名字
//     * @param userId           解除处罚的用户
//     * @return 如果当前用户正在被处罚中，解除当前处罚，返回处罚记录id，如果用户没有被处罚，返回-1表示解除处罚非法
//     */
//    public int relieve(String operatorUserName, int userId) {
//    }
//
//    public static void main(String[] args) throws Exception {
//        T2 main = new T2();
//        Scanner in = new Scanner(System.in);
//        List<HistoryResult> printHistory = new ArrayList<>();
//        List<Integer> printOperators = new ArrayList<>();
//        int opNum = Integer.parseInt(in.nextLine());
//        while (in.hasNext()) {
//            String op = in.nextLine();
//            String data = in.nextLine();
//            if (op.equals("punish")) {
//                String[] punishData = data.split(" ");
//                String operatorUserName = punishData[0];
//                int userId = Integer.parseInt(punishData[1]);
//                int punishStatus = Integer.parseInt(punishData[2]);
//                printOperators.add(main.punish(operatorUserName, userId, punishStatus));
//            } else if (op.equals("relieve")) {
//                String[] relieveData = data.split(" ");
//                String operatorUserName = relieveData[0];
//                int userId = Integer.parseInt(relieveData[1]);
//                printOperators.add(main.relieve(operatorUserName, userId));
//            } else if (op.equals("getByUserId")) {
//                int userId = Integer.parseInt(data);
//                List<HistoryResult> results = main.getByUserId(userId);
//                if (results != null && !results.isEmpty()) {
//                    printHistory.addAll(results);
//                }
//            } else if (op.equals("query")) {
//                String[] queryData = data.split(" ");
//                int pageNo = Integer.parseInt(queryData[0]);
//                int pageSize = Integer.parseInt(queryData[1]);
//                List<HistoryResult> results = main.query(pageNo, pageSize);
//                if (results != null && !results.isEmpty()) {
//                    printHistory.addAll(results);
//                }
//            } else {
//                throw new Exception("错误的输入");
//            }
//        }
//        printHistory.forEach(res -> System.out.println(res.getId() + "_" + res.getUserId() + "_" + res.getOperatorUserName() + "_" + res.getStatus()));
//        printOperators.forEach(System.out::println);
//    }

}
class HistoryResult {
    private int id;
    private int userId;
    private String operatorUserName;
    private int status;

    HistoryResult(int id, int userId, String operatorUserName, int status) {
        this.id = id;
        this.userId = userId;
        this.operatorUserName = operatorUserName;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getOperatorUserName() {
        return operatorUserName;
    }

    public int getStatus() {
        return status;
    }
}
