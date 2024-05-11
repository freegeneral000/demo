$(function() {
  $("#title, #content").on("keyup", function () {
    const title = $("#title").val();
    const content = $("#content").val();

    const $submitButton = $("#submitBtn");

    if (title.length === 0 || content.length === 0) {
      $submitButton.addClass("disabled");
    } else {
      $submitButton.removeClass("disabled");
    }
  })
})