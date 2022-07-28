const baseUrl = '/DormitorySystem';
function  page_jump_to(num) {
    var regexp = /^[1-9]\d*$/;
    var totalPageCount = document.getElementById("totalPageCount").value;
    if (!regexp.test(num)) {
        alert("请输入大于0的正整数！")
        return false;
    } else if ((num - totalPageCount) > 0) {
        alert("请输入小于总页数的页码");
        return false;
    } else {
        location = "?pageNum=" + num
    }
}