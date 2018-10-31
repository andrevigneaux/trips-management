$(document).ready(function() {
    $('.createEditForm #createEditModal').on('hidden.bs.modal', function (e) {
      $('.createEditForm #createEditModal .model-body').html("");
    })

    $('#editButton, #newButton').on('click', function(event){
        event.preventDefault();
        var href = $(this).attr('href');
        var name = $(this).attr('name');
        if(name == 'edit') {
            $.get(href,function(trip, status) {
                $('.createEditForm #tripId').val(trip.id);
                $('.createEditForm #tripName').val(trip.name);
                $('.createEditForm #tripDate').val(getFormattedDate(trip.date));
            })
        }

        $('.createEditForm #createEditModal').modal();
    })
});

function getFormattedDate(date) {
    var formattedDate = new Date(date);
    var d = formattedDate.getDate();
    var m =  formattedDate.getMonth();
    m += 1;  // JavaScript months are 0-11
    d += 1;
    var y = formattedDate.getFullYear();
    return y + "-" + m + "-" + d;
}