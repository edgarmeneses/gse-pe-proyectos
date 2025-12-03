import PyPDF2
import sys

def extract_text_from_pdf(pdf_path, output_path):
    """Extract text from PDF and save to text file"""
    try:
        with open(pdf_path, 'rb') as pdf_file:
            pdf_reader = PyPDF2.PdfReader(pdf_file)
            text = []
            
            print(f"Total pages: {len(pdf_reader.pages)}")
            
            for page_num in range(len(pdf_reader.pages)):
                page = pdf_reader.pages[page_num]
                page_text = page.extract_text()
                text.append(f"\n\n=== PAGE {page_num + 1} ===\n\n")
                text.append(page_text)
            
            full_text = ''.join(text)
            
            with open(output_path, 'w', encoding='utf-8') as output_file:
                output_file.write(full_text)
            
            print(f"Text extracted successfully to {output_path}")
            print(f"Total characters: {len(full_text)}")
            
    except Exception as e:
        print(f"Error extracting PDF: {e}")
        sys.exit(1)

if __name__ == "__main__":
    pdf_path = "Microservicio MsDatosRepositorioDocumental V1.3.pdf"
    output_path = "ESPECIFICACION_EXTRAIDA.txt"
    extract_text_from_pdf(pdf_path, output_path)
