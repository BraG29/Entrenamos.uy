function upperDateControler() {
    var dateControler = {
        currentDate: null
    }

    $(document).on("change", "#fechaInput", function (event, ui) {
        var now = new Date();
        var selectedDate = new Date($(this).val());

        if (selectedDate > now) {
            $(this).val(dateControler.currentDate)
        } else {
            dateControler.currentDate = $(this).val();
        }
    });
}

function lowerDateControler() {
    var dateControler = {
        currentDate: null
    }

    $(document).on("change", "#fechaClaseInput", function (event, ui) {
        var now = new Date();
        var selectedDate = new Date($(this).val());

        if (selectedDate < now) {
            $(this).val(dateControler.currentDate)
        } else {
            dateControler.currentDate = $(this).val();
        }
    });
}

function toggleSection() {
    if (document.getElementById("zonaRegistroProfesor").style.display === "none") {
        document.getElementById("zonaRegistroSocio").style.display = "none";
        document.getElementById("zonaRegistroProfesor").style.display = "";
    }
    else {
        document.getElementById("zonaRegistroProfesor").style.display = "none";
        document.getElementById("zonaRegistroSocio").style.display = "";
    }
}