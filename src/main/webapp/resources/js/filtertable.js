$(document).ready(function(){
  $("#txtTimKiem").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
    var count = $('tr:visible').length -1;
    $("#count").text("Số kết quả: " + count);
  });
});